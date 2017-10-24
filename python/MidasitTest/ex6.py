def combination(n,r):
    return f(n)/f(r)/f(n-r)

def f(n):
    fac=1
    for i in range(1,n+1):
        fac=fac*i
    return fac

data = input()
n=(int)(data.split(' ')[0])
m=(int)(data.split(' ')[1])


data=input()
passdata=data.split(' ')
con=0 #자음
vow=0 #모음(a,e,i,o,u)

for i in passdata:
    if i=='a'or i=='A' or  i=='e' or i=='E' or i=='i' or i=='I' or i=='o' or i=='O' or i=='u' or i=='U':
        vow=vow+1
    else:
        con=con+1


if con<n:
    result=(int)(combination(m,n))
else:
    result=(int)(combination(m,n)-combination(con,n))

print(result)



print(passdata)
