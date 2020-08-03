
//mimic the server behaviour
const posts = [
    { title: 'post one ', body: 'this is post one' },
    { title: 'post two ', body: 'this is post two ' }
];

function getPosts() {
    setTimeout(_ => {
        let output = '';
        posts.forEach((post, index) => {
            output += `<li>${post.title}</li>`;
        });
        console.log('result given by server');
        document.body.innerHTML = output;
    }, 1000);
}

function createPost(post) {

    return new Promise((resolve, reject) => {

        setTimeout(_ => {
            posts.push(post);

            const error = false;
            if (!error) {
                resolve("success");
            } else {
                reject('Error: something went wronge');
            }

        }, 2000);
    });



}

//mimic the  server ends




async function init() {
    //we telling wait untill createPost get result
    await createPost({ title: 'post three new ishan', body: 'This is post 3' });
    getPosts();

}

init();

(async function () {
    const request = await fetch('https://jsonplaceholder.typicode.com/users');
    //we must get json again by fetch (little weird fetch api)
    const data = await request.json();

    const request2 = await (await fetch('https://randomuser.me/api/?results=1')).json();

    console.log(data);
    console.table(request2.results[0]);
})()