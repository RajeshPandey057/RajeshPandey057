echo "Enter a:"
read a;
for i in {1..5}
do	
	echo $a
	a=` expr $a + 3  `
done 
