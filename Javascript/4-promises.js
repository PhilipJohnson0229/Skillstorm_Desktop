//we use the promise constructor to create a promise
const createPromise = (num)=>{
    return new Promise((resolve, reject) =>{
        if(num < 10)
        {
            reject('Number can\'t be less than 10');
        }else
        {
            resolve(`Number received!  Your number is ${num}`);
        }
    });
}

const newPromise = createPromise(12);

//first param is data

newPromise.then(data =>{
    console.log('handling the promise');
    console.log(data);
}).catch(err => console.error(err)/*this is useing the error out stream*/);

//chaining promises
//.then and .catch return a promise

//immmediately fullfilling a promise
Promise.resolve(1)
.then(num => num + 1)//returns 2 as a new fulfilled promise
.then(num => {console.log(num); throw num + 1;})
.then(num => {console.log(num); return num + 10;})//this line gets skipped
.catch(num => console.log(num)).finally(()=> console.log('Finally done!'));

//multiple promises concurrently
const createTimedPromise = (time, promiseName) => 
{
    return new Promise((resolve, reject) =>
    {
        setTimeout(()=>{
            if(promiseName === 'Medium Promise')
            {
                reject(`${promiseName} was rejected!`);
            }
            resolve(`${promiseName} was fulfilled!`);
        },time);
    });
}

const shortPromise = createTimedPromise(3000, 'Short Promise');
const mediumPromise = createTimedPromise(5000, 'Medium Promise');
const longPromise = createTimedPromise(8000, 'Long Promise');

//tales in an array of promises
Promise.all([shortPromise, mediumPromise, longPromise])
.then(data => console .log(data))
.catch(err => console.log(err));