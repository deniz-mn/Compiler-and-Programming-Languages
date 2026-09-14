from pathlib import Path
import shutil

# فایل پایتون باید مستقیماً داخل پوشه PHASE_4 باشد
PROJECT_ROOT = Path(__file__).resolve().parent

OUTPUT_FILE = PROJECT_ROOT / "all_project_code.txt"

# نام پوشه دقیقاً مطابق تصویر
TARGET_DIRS = [
    PROJECT_ROOT / "src",
    PROJECT_ROOT / "Sample",
]

# فایل‌های باینری که نباید داخل txt نوشته شوند
BINARY_EXTENSIONS = {
    ".class",
    ".jar",
    ".zip",
    ".pdf",
    ".png",
    ".jpg",
    ".jpeg",
    ".gif",
    ".exe",
    ".dll",
    ".so",
    ".bin",
}


def is_binary_file(filepath: Path) -> bool:
    """تشخیص تقریبی فایل باینری بدون خواندن کامل فایل."""
    if filepath.suffix.lower() in BINARY_EXTENSIONS:
        return True

    try:
        with filepath.open("rb") as file:
            first_bytes = file.read(8192)

        return b"\x00" in first_bytes

    except OSError:
        return True


def main():
    print(f"Project root: {PROJECT_ROOT}")
    print(f"Output file: {OUTPUT_FILE}")
    print()

    merged_count = 0
    skipped_count = 0

    existing_folders = []

    for folder in TARGET_DIRS:
        if folder.is_dir():
            existing_folders.append(folder)
            print(f"Found folder: {folder}")
        else:
            print(f"Folder not found: {folder}")

    if not existing_folders:
        print("\nError: neither src nor Sample was found.")
        print("Put this Python file directly inside PHASE_4.")
        return

    with OUTPUT_FILE.open(
        "w",
        encoding="utf-8",
        errors="replace"
    ) as outfile:

        for folder in existing_folders:
            files = sorted(
                path
                for path in folder.rglob("*")
                if path.is_file()
            )

            print(f"\n{folder.name}: {len(files)} files found")

            for filepath in files:
                relative_path = filepath.relative_to(PROJECT_ROOT)

                if is_binary_file(filepath):
                    print(f"Skipped binary: {relative_path}")
                    skipped_count += 1
                    continue

                print(f"Merging: {relative_path}")

                outfile.write("\n\n")
                outfile.write("=" * 90 + "\n")
                outfile.write(f"FILE: {relative_path.as_posix()}\n")
                outfile.write("=" * 90 + "\n\n")

                try:
                    # محتوا مرحله‌به‌مرحله کپی می‌شود؛ مناسب فایل‌های حجیم
                    with filepath.open(
                        "r",
                        encoding="utf-8",
                        errors="replace"
                    ) as infile:
                        shutil.copyfileobj(
                            infile,
                            outfile,
                            length=1024 * 1024
                        )

                    outfile.write("\n")
                    merged_count += 1

                except OSError as error:
                    outfile.write(
                        f"\nERROR READING FILE: {error}\n"
                    )
                    print(f"Error reading {relative_path}: {error}")

    print("\n" + "-" * 50)
    print(f"Finished successfully.")
    print(f"Merged files: {merged_count}")
    print(f"Skipped binary files: {skipped_count}")
    print(f"Output path: {OUTPUT_FILE}")
    print(f"Output exists: {OUTPUT_FILE.exists()}")

    if OUTPUT_FILE.exists():
        size_mb = OUTPUT_FILE.stat().st_size / (1024 * 1024)
        print(f"Output size: {size_mb:.2f} MB")


if __name__ == "__main__":
    main()