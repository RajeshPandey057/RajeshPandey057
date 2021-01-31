echo "Enter CPi"
read a;

if  [ $a -gt 6 ] || [ $a -eq 6 ] && [ $a -lt 7 ] 
	then echo "passed with second class"$a
	
elif  [ $a -gt 7 ] || [ $a -eq 7 ]  && [ $a -lt 8 ] 
	then echo "passed with first class"$a
	
elif  [ $a -gt 8 ] || [ $a -eq 8 ] &&  [ $a -lt 10 ] || [ $a -eq 10 ] 
	then echo "Distinction"$a

else
	echo "incorrect values"
fi

