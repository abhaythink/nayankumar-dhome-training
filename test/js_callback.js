let arr = [25, 10, 45, 50, 55, 50];

let result = arr.every((ele) => ele % 5 === 0);
console.log(result);

// Basic callback
function greet(name = 'Guest', callback) {
    console.log(`Hello ${name}`);
    callback();
}

// callback function
function welcome() {
    console.log("Welcome!");
}

greet('Nayankumar', welcome);

// async function demo
function printInfo(callback) {
    setTimeout(function() {
        console.log("Printing the info here...");
        callback("Call back....");
    }, 2000)  // 2 sec delay
}

// callback
function displayMsg(msg) {
    console.log(msg);
}

printInfo( displayMsg);


function fetchUsersData(userId, callback) {
    setTimeout(function () {
        const users = {
            1: { id: 101, name: 'Nayan' },
            2: { id: 201, name: 'Rohit' }
        };

        const user = users[userId];

        if (user) {
            callback(null, user);
        } else {
            callback("User not found...", null);
        }
    }, 3000);
}

function handleUserData(error, user) {
    if (error) {
        console.error("Error:", error);
    } else {
        console.log("User:", user);
    }
}

fetchUsersData(1, handleUserData);
fetchUsersData(3, handleUserData);

// Promise

const userLeft = false;
const userWatchingVideo = false;

function watchingVideoPromise() {
    return new Promise((resolve, reject) => {
        if(userLeft) {
            reject("User is Left :(");
        } else if(userWatchingVideo) {
            reject("User is Watching a video.");
        } else {
            resolve("Like Share and Subscribe!");
        }
    });
}

watchingVideoPromise()
    .then((msg) => {
        console.log("Success: " + msg);
    })
    .catch((error) => {
        console.error("Error:", error);
    });


const postCreated = false;
const postUploaded =false;

const promise1 = new Promise((resolve, reject) => {
    if(postCreated) {
        resolve("Post get created :)");
    } else {
        reject("No post for today :(");
    }
});

const promise2 = new Promise((resolve, reject) => {
    if(postCreated && postUploaded) {
        resolve("Plz watch today's post :)");
    } else {
        reject("Wait for sometime, post uploading soon..");
    }
});

Promise.all([
    promise1,
    promise2
]).then((msg) => {
    console.log("Success: " + msg);
}).catch((error) => {
    console.error("Error: " + error);
});

Promise.race([
    promise1,
    promise2
]).then((msg) => {
    console.log("Success: " + msg);
}).catch((error) => {
    console.error("Error: " + error);
});

const resolvePromise = Promise.resolve("Promise is Resolved!");

resolvePromise.then((msg) => {
    console.log(msg);
});


const rejectPromise = Promise.reject("Promise is Rejected.");

rejectPromise.catch((error) => {
    console.error(error);
});

function makeRequest(location) {
    return new Promise((resolve, reject) => {
        console.log("Making request to " + location);
        if (location === 'Google') {
            resolve(`${location} says hello!`);
        } else {
            reject(`We are not working with ${location}`);
        }
    });
}

function processRequest(response) {
    return new Promise((resolve) => {
        console.log("Processing response...");
        resolve(`Extra information: ${response}`);
    });
}

async function doRequest() {
    try {
        const res = await makeRequest('Google');
        console.log("Response is received");
        const processedRes = await processRequest(res);
        console.log(processedRes);
    } catch (error) {
        console.error(error.message || error);
    }
}

doRequest();