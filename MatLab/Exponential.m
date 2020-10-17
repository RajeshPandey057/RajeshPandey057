n2=input('length of exponential sequence');
t=0:n2;
a=input('Enter the ‘a’ value');
y2=exp(a*t);
subplot(2,2,4);
stem(t,y2);
ylabel('Amplitude -->');
xlabel(' n -->');