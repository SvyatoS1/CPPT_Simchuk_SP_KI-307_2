import os
import struct
import sys
import math
import struct
def writeResTxt(fName, result):
    with open(fName, 'w') as f:
        f.write(str(result))
def readResTxt(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r') as f:
                result = f.read()
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
        return result
def writeResBin(fName, result):
    with open(fName, 'wb') as f:
        # See https://docs.python.org/3/library/struct.html
        f.write(struct.pack('f', result))
def readResBin(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
                # See https://docs.python.org/3/library/struct.html
                 result = struct.unpack('f', f.read())[0]
        else:
                raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result
def calculate(x):
    try:
        numerator = math.tan(x)
        denominator = math.sin(4 * x) - 2 * math.cos(x)
        y = numerator / denominator
        return y
    except ZeroDivisionError:
        return None  # Обробка помилки ділення на нуль
if __name__ == "__main__":
    data = float(input("Enter data: "))
    result = calculate(data)
    print(f"Result is: {result}")
    try:
        writeResTxt("textRes.txt", result)
        writeResBin("binRes.bin", result)
        print("Result is: {0}".format(readResBin("binRes.bin")))
        print("Result is: {0}".format(readResTxt("textRes.txt")))
    except FileNotFoundError as e:
         print (e)
         sys.exit(1)
