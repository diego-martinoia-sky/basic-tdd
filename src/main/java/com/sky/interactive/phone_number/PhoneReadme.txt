Write a program that cleans up user-entered phone numbers so that they can be sent SMS messages.

The rules are as follows:

If the phone number is less than 10 digits assume that it is bad number
If the phone number is 10 digits assume that it is good
If the phone number is 11 digits and the first number is 1, trim the 1 and use the last 10 digits
If the phone number is 11 digits and the first number is not 1, then it is a bad number
If the phone number is more than 11 digits assume that it is a bad number

In case of a bad phone number, the getPhoneNumber method should return a String of 10 0's.
In case of a good phone number, the getAreaCode method should return a String containing the phone's area code
(first 3 digits).

The "pretty" method should return a String of the phone number pretty-printed. A pretty-printed phone number
has the format:

(areaCode) XXX-YYYY

Your code for the "setPhoneNumber" method needs to be able to handle any format of phone number. That is to say
manage parenthesis, dots, dashes, spaces, etc.