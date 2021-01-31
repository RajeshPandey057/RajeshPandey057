read loop
sum1=0
sum2=0
for ((i = 0 ; i < loop ; i++)); do
    read no
    check=$(( $no % 2 ))
    if [ $check = 0 ]
    then
    sq=$(( $no * $no ))
    sum1=$(( $sum1 + $sq ))
    else
    sq=$(( $no * $no ))
    sum2=$(( $sum2 + $sq ))
    fi
done
result=$(( $sum1 - $sum2 ))
echo $result