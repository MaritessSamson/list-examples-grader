CPATH='.;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

if [[ -f student-submission/ListExamples.java ]] 
then
    echo "ListExamples.java file found."
else
    echo "ListExamples.java file not found."
    echo "Grade: 0"
    exit
fi

cp TestListExamples.java student-submission/ListExamples.java grading-area
cp -r lib grading-area


# Then, add here code to compile and run, and do any post-processing of the
# tests
cd grading-area
javac -cp $CPATH *.java

echo "The exit code for the compile step is $?"
if [[ $? -ne 0 ]]
then
    echo "There is an error in the code. Grading ended"
    echo "Grade: 0"
    exit
else
    echo "We can grade."
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > grade-results.txt
echo "The exit code for the compile step is $?"


if [[ $? -ne 0 ]]
then
    echo `grep "Failures" grading-area/grade-results.txt`
    exit
else
    echo "Grade: 100"
fi

