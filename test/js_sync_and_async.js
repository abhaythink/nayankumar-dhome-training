console.log("---||------------------|Sync/Async|--------------------||---");

console.log("start");
for(let i = 0; i < 5; i++) {
    console.log(i);
}
console.log("end");
/*
output:
start
0
1
2
3
4
end
*/
// javascript has by defoult syncronus behaviour the execute the code one by one line/task and its a single threaded lang


console.log("start");
setTimeout(() => {
    console.log("Task completed.")
},2000);
console.log("end");

// setTimeout is async in nature 
/*
output:
start
end
Task completed      :: executed after 2 sec
*/