async function anAsyncFunction()
{

}

const asyncArrowFunction = async () =>
{
    return 'sweet!';
}

/*const message = asyncArrowFunction();
console.log(message);*/

const withAwait = async()=>
{
    try {
        const message = await asyncArrowFunction();
        console.log(message);
    } catch (error) {
        console.log('Inside the catch block ' + error);
    }
}

withAwait();