import os

# پوشه‌هایی که می‌خواهیم کدهایشان را ترکیب کنیم
target_dirs = ['src']
# پسوندهای مجاز
allowed_extensions = ['.java', '.g4']
output_filename = 'all_project_code.txt'

with open(output_filename, 'w', encoding='utf-8') as outfile:
    for root, dirs, files in os.walk('.'):
        # نادیده گرفتن پوشه‌های اضافی و خروجی کامپایلر
        if any(exclude in root for exclude in ['.idea', 'out', 'gen', 'samples', 'utilities']):
            continue
            
        for file in files:
            if any(file.endswith(ext) for ext in allowed_extensions):
                filepath = os.path.join(root, file)
                
                # نوشتن نام فایل به عنوان جداکننده
                outfile.write(f"\n\n{'='*60}\n")
                outfile.write(f"/// FILE: {filepath} ///\n")
                outfile.write(f"{'='*60}\n\n")
                
                # خواندن محتوای فایل و نوشتن در خروجی
                try:
                    with open(filepath, 'r', encoding='utf-8') as infile:
                        outfile.write(infile.read())
                except Exception as e:
                    outfile.write(f"// Error reading file: {e}\n")

print(f"Done! All codes merged into: {output_filename}")