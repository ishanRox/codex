

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
    setTimeout(_ => {
        posts.push(post);
        console.log('post created');
    }, 2000);
}

//mimic the  server ends

//send a get request take 1s 
//getPosts();
//send create request take 2s
//createPost({ title: 'post three new ishan', body: 'This is post 3' })

//because it takes only 1 s to get and 2 s to create result get first and after 1s only post added


//send create request take 2s
 createPost({ title: 'post three new ishan', body: 'This is post 3' });

function sleep(seconds) {
    var start = new Date().getSeconds();
    console.log(`start time ${start}`);
    while (true) {
        const currentTime = new Date().getSeconds();
        if ((currentTime - start) > seconds) {
            console.log(`currentTime ${currentTime}`);
            break;
        }
    }
}

sleep(5);

getPosts();