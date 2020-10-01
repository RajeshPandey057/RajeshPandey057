mvi c,01h
mvi a,0ah
lxi h,2000h
strt:	mov m,c
	inx h
	inr c
	dcr a
	jnz strt
mvi c,0ah
lxi h,1000h
loop:	push b
	push h
	mvi a,00h
	call min
	pop h
	pop b
	call swp
	mvi h,20h
	mvi d,20h
 	call swp
	mvi d,10h
	mvi h,10h
	inx h
	dcr c
	jnz loop
hlt
min:	mov b,m
	cmp b
	jz nxt
	jnc  nxt
	mov a,b
	push h
	pop d
nxt:	inx h	
	dcr c
	jnz min
	ret
swp:	ldax d
	mov b,m
	mov m,a
	mov a,b
	stax d
	ret