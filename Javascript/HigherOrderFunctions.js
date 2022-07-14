//the arrow symbol turns this function into an object
const timesX = (x) => 
{
    //we are going to return another function
    //a closure
    return (y)=>
    {
        return x*y;
    }
};

//sets 5 as x
//const times5 = timesX(5);

//console.log(times5(10));

//put in one line
console.log(timesX(50)(2));

const planets= ['earth','vegeta','krypton','viltrum'];

function printPlanet(planets)
{
console.log(planets);
}

planets.forEach(printPlanet);


const pleanetsWithAnE = planets.filter(planet => {
    return planet.includes('e') || planet.includes('E');
});

console.log(pleanetsWithAnE);

console.log(5 === '5');