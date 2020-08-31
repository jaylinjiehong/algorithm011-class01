/*
 * @lc app=leetcode.cn id=841 lang=javascript
 *
 * [841] 钥匙和房间
 */

// @lc code=start

var canVisitAllRooms = function(rooms, key = 0, keys = new Set()) {

    if (keys.has(key)) return;

    keys.add(key);

    rooms[key].forEach(k => canVisitAllRooms(rooms, k, keys));

    return keys.size == rooms.length;

};
/**
 * bfs
 * @param {number[][]} rooms
 * @return {boolean}
 */
// var canVisitAllRooms = function(rooms) {
//     let set = new Set();
//     let queue = [];
//     queue.push(0);
//     set.add(0);
//     while (queue.length) {
//         let nextRooms = rooms[queue.shift()];
//         for (let i = 0; i < nextRooms.length; i++) {
//             let next = nextRooms[i];
//             if (!set.has(next)) {
//                 queue.push(next);
//                 set.add(next);
//             }
//         }
//     }
//     if (rooms.length == set.size) {
//         return true;
//     } else {
//         return false;
//     }
// };




// /**
//  * dfs
//  * @param {number[][]} rooms
//  * @return {boolean}
//  */
// var canVisitAllRooms = function (rooms) {
//     let set = new Set();
//     dfs(rooms, 0, set);
//     if (rooms.length == set.size) {
//         return true;
//     } else {
//         return false;
//     }
// };

// function dfs(rooms, room, set) {
//     if (set.has(room)) {
//         return;
//     }
//     set.add(room);
//     for (let item of rooms[room]) {
//         dfs(rooms, item, set);
//     }
// }
// @lc code=end