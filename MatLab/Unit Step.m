clc;
clear all;
close all;
n=input('enter the N value');
t=0:1:n-1;
y1=ones(1,n);
subplot(2,2,2);
stem(t,y1);ylabel('Amplitude -->');
xlabel(' n -->');