#chmod +x myscript.sh
#for the permissions to run this file
#which bash
#to identify the bash path
#!/usr/bin/bash

#print something
echo hello world ishan

#variables
#Uppercase by convention
#Letters,numbers,underscores
NAME="ishan"
echo "myname is $NAME"
echo "my name is again ${NAME}(like js literal)"

#user input
read -p "Enter your name :" NAME

#simple if statement care about spaces in []
if [ "$NAME" == "ishan" ]; then
    echo "hail ishan"
elif [ "$NAME" == "nishi" ]; then
    echo "what a cute name patto !"
else
    echo "hello $NAME fuck off lord ishan only can enter"
fi

#operators -eq ,-ne,-gt,-ge,-lt,-le
NUM1=31
NUM2=5

if [ "$NUM1" -gt "$NUM2" ]; then
    echo "$NUM1 is greater than $NUM2"
else
    echo "$NUM1 is less than $NUM2"
fi

#File conditions
# -d file true if the file is a directory
# -e true if the file exiss
# -f file true if the provided string is a file
#-g file true if the froup id is set on a file

FILE="test.txt"

if [ -f "$FILE" ]; then
    echo "$FILE is a file"
else
    echo "$FILE is not a file"
fi

#switch statements

read -p "Are u 21 or over ? y/n " ANSWER
case "$ANSWER" in
[yY] | [yY][eE][sS])
    echo "you can have a beer :-)"
    ;;
[nN] | [nN][oO])
    echo "sorry no drinking"
    ;;
*)
    echo "please enter given shit"
    ;;
esac

#loops
#simple for loop(for each loop)

NAMES_ARRAY="ISHAN VIMUKTHI  VIHANGA"

for name in $NAMES_ARRAY; do
    echo "hello $name"
done

#while loop
COUNTER=0

while [ $COUNTER -le 10 ]; do
    echo "hello $COUNTER"
    ((COUNTER++))
done

#range loop

for value in {1..12}; do
    echo $value
done

#range  decrease loop with steps
for value in {8..1..2}; do
    echo "ranges $value"
done

for value in {1..5}; do
    touch "ishan$value.txt"
done

#rename files script $(commands can run and give output to here)
# textFILES=$(ls *.txt) #get all the files
# NEW="new"
# for file in $textFILES; do
#     echo "renaming file $file to new-$file"
#     mv $file $NEW-$file
#     #rename the file (mv oldname newname)
# done

#read a file
LINE=1
while read -r CURRENT_LINE; do
    echo "$LINE: $CURRENT_LINE"
    ((LINE++))
done <"./a.txt"

#Functions

function sayHello() {
    echo "hello world"
}

sayHello

function greet() {
    echo "hello i am $1 im $2"
}

greet "ishan" "26"

#create folder and write files
#make dir hello
mkdir hello
#make file inside it
touch "hello/ishan.txt"
#write to that file
echo "hello im ishan" >>"hello/ishan.txt"
echo "created folder hello and file ishan"
