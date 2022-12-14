import sys

# Each dictionary is a collection of the horizontal segments
# of each number: either top, middle or bottom.

top = {
    1: "   ",
    2: " _ ",
    3: " _ ",
    4: "   ",
    5: " _ ",
    6: " _ ",
    7: " _ ",
    8: " _ ",
    9: " _ ",
    0: " _ "
}

middle = {
    1: "  |",
    2: " _|",
    3: " _|",
    4: "|_|",
    5: "|_ ",
    6: "|_ ",
    7: "  |",
    8: "|_|",
    9: "|_|",
    0: "| |"
}

bottom = {
    1: "  |",
    2: "|_ ",
    3: " _|",
    4: "  |",
    5: " _|",
    6: "|_|",
    7: "  |",
    8: "|_|",
    9: " _|",
    0: "|_|"
}


def validate(arg_index, name):
    try:
        arg = sys.argv[arg_index]
    except IndexError:
        sys.exit(name + ": missing argument")
    if not arg.isnumeric():
        sys.exit(name + ": must be a numeric value")
    return arg


def printTop():
    # Top horizontal segment only needs a base row
    printBaseOfRow(top)


def printMiddle():
    printFillerOfRow(middle)
    printBaseOfRow(middle)


def printBottom():
    printFillerOfRow(bottom)
    printBaseOfRow(bottom)


def printBaseOfRow(row):
    # Regardless of height, there will always be a base row
    output = ""
    for num in numbers:
        output += addBaseNumber(row[int(num)])
    print(output)


def printFillerOfRow(row):
    # As many filler rows are added as defined by 'height'
    row_num = 1
    while row_num < height:
        output = ""
        for num in numbers:
            output += addFillerNumber(row[int(num)])
        print(output)
        row_num += 1


def addBaseNumber(chars):
    # Adding the default segment of a number
    return addNumber(chars, chars[1])


def addFillerNumber(chars):
    # Adding the segment of a number but empty in the middle
    return addNumber(chars, " ")


def addNumber(chars, middle_char):
    output = ""
    output += chars[0]
    output += middle_char * width
    output += chars[2]
    return output


if __name__ == "__main__":
    numbers = validate(1, "numbers")
    width = int(validate(2, "width"))
    height = int(validate(3, "height"))

    printTop()
    printMiddle()
    printBottom()
