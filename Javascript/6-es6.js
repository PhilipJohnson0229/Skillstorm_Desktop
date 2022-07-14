//an Object
const sally = {
fullName:{
    firstName:'sally',
    lastName:'grace'
},
age : 27,
favColor : 'Red',
hobbies : '',
favFood : ''

}

let sallyAge = sally.age;

//gives an object {} gain the properties of the sally object
let {age, fullName, hobbies} =  sally;
console.log(sally);
console.log(sally.fullName.lastName);