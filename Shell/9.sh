echo "Enter a:"
read a; 
echo "this will show 1 if it is pelendrom and 0 if it is not."
echo $( expr $a = $( echo $a | rev ))  
