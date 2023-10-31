"""
ROT13 is a simple letter substitution cipher that replaces a letter with the letter 13 letters after it in the alphabet. ROT13 is an example of the Caesar cipher.

Create a function that takes a string and returns the string ciphered with Rot13. If there are numbers or special characters included in the string, they should be returned as they are. Only letters from the latin/english alphabet should be shifted, like in the original Rot13 "implementation".
"""
def rot13(message):
    decoded = ""
    for char in message:
        decode_char = ord(char)
        if (decode_char >= 65 and decode_char <= 90):
            decode_char += 13
            if decode_char > 90:
                decode_char -= 26
            decoded += chr(decode_char)
        elif(decode_char >= 97 and decode_char <= 122):
            decode_char += 13
            if decode_char > 122:
                decode_char -= 26
            decoded += chr(decode_char)
        else:
            decoded += chr(decode_char)
    return decoded