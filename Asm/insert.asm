mvi c,55
mvi a,0ah
lxi h,1000h
strt:	mov m,c
	inx h
	dcr c
	dcr a
	jnz strt
mvi c,01
mvi a,0ah
lxi h,2000h
strt1:	mov m,c
	inx h
	inr c
	dcr a
	jnz strt1
mvi b,50
mvi c,0ah
lxi h,1000h
loop:	mov a,m
	cmp b
	jz nxt
	jnc nxt
	push h
	pop d
	lxi h,1009h
	call swp
	mvi d,20h
	lxi h,2009h
	mvi b,21
	call swp
hlt
nxt:	inx h
	dcr c
	jnz loop
hlt
swp:	mov a,m
	inx h
	mov m,a
	dcx h
	dcx h
	dcr c
	jnz swp
	mov a,b
	stax d
	ret
	