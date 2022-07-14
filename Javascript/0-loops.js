let i = 0;

while(i < 5)
{
    console.log(i++);
}

//for
for(let i = 0; i < 10; i ++)
{
    console.log(i);
}

//do while
do{
    console.log('this only runs once but if we used true it would be infinite')
}while(false);


//for of

const nums = [1,2,3];
for (let num of nums) {
    console.log(num);
} 

for(let num in nums)
{
    console.log(num);
}