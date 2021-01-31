echo "Enter a:"
read a;
echo "Enter b:"
read b;
echo "Enter"
echo "1.To do sumation"
echo "2.To do substraction"
echo "3.To do multipication"
echo "4.To do division"
read d;
case $d in
1)echo "Sum is :" $(expr $a + $b )
	;;
2)echo "Substraction is :" $(expr $a - $b )
	;;
3)echo "Multipiction is :" $(expr $a \* $b )
	;;
4)echo "Divsion is :" $(expr $a / $b )
	;;
esac
