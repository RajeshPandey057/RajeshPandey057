echo "Enter a:"
read a;
until [ $a -lt 0 ]
do	
	echo $a
	a=` expr $a - 1 `
done 
