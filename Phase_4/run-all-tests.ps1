Write-Host "TEST SCRIPT STARTED" -ForegroundColor Magenta
if ((Split-Path -Leaf (Get-Location)) -eq "codeGenOutput") {
    Set-Location ..
}

$antlrJar = Get-ChildItem . -Recurse -File -Filter "antlr-4.13.1-complete.jar" |
    Select-Object -First 1 -ExpandProperty FullName

$jasminJar = Get-ChildItem . -Recurse -File -Filter "jasmin.jar" |
    Select-Object -First 1 -ExpandProperty FullName

if (-not $antlrJar) {
    throw "ANTLR jar not found"
}

if (-not $jasminJar) {
    throw "jasmin.jar not found"
}

Remove-Item -Recurse -Force .\gen, .\out, .\codeGenOutput `
    -ErrorAction SilentlyContinue

New-Item -ItemType Directory -Force .\gen, .\out | Out-Null

java -jar "$antlrJar" `
    -Dlanguage=Java `
    -no-listener `
    -Xexact-output-dir `
    -o .\gen `
    .\src\main\grammar\SimpleLang.g4

if ($LASTEXITCODE -ne 0) {
    throw "ANTLR generation failed"
}

$javaFiles = Get-ChildItem .\src, .\gen -Recurse -File -Filter *.java |
    ForEach-Object { $_.FullName }

javac -cp "$antlrJar" -d .\out $javaFiles

if ($LASTEXITCODE -ne 0) {
    throw "Java compilation failed"
}

$molFiles = Get-ChildItem .\Sample -File -Filter *.mol |
    Sort-Object Name

if ($molFiles.Count -eq 0) {
    throw "No .mol files found in Sample"
}

$passedTests = @()
$failedTests = @()

foreach ($molFile in $molFiles) {
    Write-Host "`n========================================" -ForegroundColor Cyan
    Write-Host "TEST: $($molFile.Name)" -ForegroundColor Yellow
    Write-Host "========================================" -ForegroundColor Cyan

    Remove-Item -Recurse -Force .\codeGenOutput `
        -ErrorAction SilentlyContinue

    java -cp ".\out;$antlrJar" SimpleLang $molFile.FullName

    if ($LASTEXITCODE -ne 0) {
        Write-Host "FAILED: Code generation" -ForegroundColor Red
        $failedTests += $molFile.Name
        continue
    }

    if (-not (Test-Path .\codeGenOutput)) {
        Write-Host "FAILED: codeGenOutput was not created" -ForegroundColor Red
        $failedTests += $molFile.Name
        continue
    }

    Push-Location .\codeGenOutput

    try {
        $jasminFiles = Get-ChildItem -File -Filter *.j |
            ForEach-Object { $_.FullName }

        if ($jasminFiles.Count -eq 0) {
            Write-Host "FAILED: No Jasmin files generated" -ForegroundColor Red
            $failedTests += $molFile.Name
            continue
        }

        java -jar "$jasminJar" $jasminFiles

        if ($LASTEXITCODE -ne 0) {
            Write-Host "FAILED: Jasmin assembly" -ForegroundColor Red
            $failedTests += $molFile.Name
            continue
        }

        Write-Host "`nPROGRAM OUTPUT:" -ForegroundColor Green

        if ($molFile.BaseName -match "input") {
            "7" | java -cp . Main
        }
        else {
            java -cp . Main
        }

        if ($LASTEXITCODE -eq 0) {
            Write-Host "PASSED: $($molFile.Name)" -ForegroundColor Green
            $passedTests += $molFile.Name
        }
        else {
            Write-Host "FAILED: Runtime error" -ForegroundColor Red
            $failedTests += $molFile.Name
        }
    }
    finally {
        Pop-Location
    }
}

Write-Host "`n========================================" -ForegroundColor Cyan
Write-Host "TEST SUMMARY" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan

Write-Host "Passed: $($passedTests.Count)" -ForegroundColor Green
$passedTests | ForEach-Object {
    Write-Host "  [PASS] $_" -ForegroundColor Green
}

Write-Host "Failed: $($failedTests.Count)" -ForegroundColor Red
$failedTests | ForEach-Object {
    Write-Host "  [FAIL] $_" -ForegroundColor Red
}