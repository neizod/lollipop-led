Ancient project since my very 1st day of programming.

This project is freezed and I'm no longer support for any bug fix.

Usage
=====

Main program is `MergeLollipop.java`, compile it and run.

You'll need pre-animated many short `*.mlf` files to concat them all together.

File Analysis
=============

Lollipop LED file name is `*.mlf`. There are 2 parts in this file.

Header
------

LED file begins with set of 6 numbers, which is in form:

    ? effect frames ? width height

for example:

    1 0 10 8211 7 15

each args meaning and values range:

    ?        unknown arg         1
    effect   builtins effect     0 to 6 (frames must be 1 if effect != 0)
    frames   no. of frames       1 to 10 (default) / hacked to int upper bound
    ?        unknown arg         8211
    width    led matrix width    7
    height   led matrix height   15

    I do guess the 4th arg stand for phone's model.
    also width and height is 7x15 for GD580 (I heard this numbers maybe vary).

Body
----

Body part contains each LED light status, line by line from upper left to lower right. No such spaces or newline (or any others character) seperated between each line of LED or animation frame.

The possible value (brightness of each LED) are:

    0 16 32 48 64 80 96 112

I don't remember exactly if the frames arg (from header part) is the indicate for how many frames in file, or you can just ignore it and only append LED animation.

License
=======

WTFPL v2.0 - neizod (C) 2010

