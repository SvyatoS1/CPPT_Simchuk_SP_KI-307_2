def generate_pattern_matrix(size, fill_char, replace_char):
    if len(fill_char) != 1 or len(replace_char) != 1:
        print("Некоректний символ-заповнювач або символ для заміни. Введіть лише один символ для кожного.")
        return None

    matrix = []
    for i in range(size):
        matrix.append([])
        for j in range(size):
            if (i == 0 or i == size - 1 or j == 0 or j == size - 1) or \
                    (i >= size // 4 and i < 3 * size // 4 and j >= size // 4 and j < 3 * size // 4):
                matrix[i].append(fill_char)
            else:
                matrix[i].append(' ')

    for i in range(size):
        if i % 2 != 0:
            for j in range(size):
                matrix[j][i] = replace_char

    return matrix

def display_pattern_matrix(matrix):
    if matrix is not None:
        for row in matrix:
            print(" ".join(row))

def write_matrix_to_file(matrix, filename):
    try:
        with open(filename, 'w') as file:
            for row in matrix:
                file.write(" ".join(row) + '\n')
        print(f"Матрицю записано у файл {filename}")
    except Exception as e:
        print("Помилка при записі у файл:", e)

if __name__ == "__main__":
    try:
        size = int(input("Введіть розмір квадратної матриці: "))
        fill_char = input("Введіть символ-заповнювач: ")
        replace_char = input("Введіть символ для заміни непарних стовпців: ")

        matrix = generate_pattern_matrix(size, fill_char, replace_char)
        display_pattern_matrix(matrix)

        if matrix is not None:
            filename = "matrix.txt"
            write_matrix_to_file(matrix, filename)
    except ValueError:
        print("Некоректне значення розміру матриці. Будь ласка, введіть ціле число.")
    except KeyboardInterrupt:
        print("\nПрограма перервана користувачем.")
    except Exception as e:
        print("Помилка:", e)
