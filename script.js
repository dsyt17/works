const mysql = require("mysql2");
const axios = require("axios");
fs = require('fs');
  
const connection = mysql.createConnection({
  host: "localhost",
  user: "admin",
  database: "wordpress",
  password: "225506",
  socketPath: '/var/run/mysqld/mysqld.sock'
});
 

let responseData = fs.readFileSync('./response.txt', 'utf8');
responseData = responseData.split('%')
// console.log(responseData);

const splittedData = []

responseData.forEach(e => {
    splittedData.push(e.split('|'))
});

// console.log(splittedData);


connection.connect((err) => {
    if (err) {
      return console.error("Ошибка: " + err.message);
    }
    else{
      console.log("Подключение к серверу MySQL успешно установлено");
    }

    splittedData.forEach(e => {

        var sql = "INSERT INTO `wp_posts` (`ID`, `post_author`, `post_date`, `post_date_gmt`, `post_content`, `post_title`, `post_excerpt`, `post_status`, `comment_status`, `ping_status`, `post_password`, `post_name`, `to_ping`, `pinged`, `post_modified`, `post_modified_gmt`, `post_content_filtered`, `post_parent`, `guid`, `menu_order`, `post_type`, `post_mime_type`, `comment_count`) "
                  +`VALUES (NULL, '1', '2022-10-28 16:41:46', '2022-10-28 16:41:46', '<!-- wp:paragraph -->\r\n<p>Вопрос: ${e[1]}</p>\r\n<p>Ответ: ${e[2]}</p>\r\n<!-- /wp:paragraph -->', '${e[0]}', '', 'publish', 'open', 'open', '', '${Math.floor(Math.random() * 100000000000000001)}', '', '', '2022-10-28 16:41:46', '2022-10-28 16:41:46', '', '0', 'http://goncharovigor.com/?p=1111', '0', 'post', '', '0'); `;
    
        connection.query(sql, function (err, result) {
            if (err) {
            return console.error("Ошибка: " + err.message);
        }
        console.log("Records inserted");
        });

    })

 });


 
// закрытие подключения
// connection.end((err) => {
    //     if (err) {
        //         return console.log("Ошибка: " + err.message);
        //     }
        // console.log("Подключение закрыто");
        // });
        
        
        
let intents = require('./intents.json');

const data = JSON.parse(JSON.stringify(intents))
console.log(data.intents[0].tag+data.intents[0].patterns+data.intents[0].responses);
console.log(data.intents.length)

let dataString = ''
const indexes = [5, 10, 15, 20, 25, 30, 35, 40]
data.intents.forEach((e, index) => {
    if (indexes.includes(index)) {
        dataString +=(e.tag+ ' | ' +e.patterns+ ' | ' +e.responses + '$' + ' % ' + ' # ')
    } else {

        dataString +=(e.tag+ ' | ' +e.patterns+ ' | ' +e.responses + '$' + ' % ')
    }
});

console.log(dataString.split('\n'))
console.log(dataString)

const splitted = dataString.split(' # ')
console.log(splitted)

const options = {
  method: 'POST',
  url: 'https://ai-translation-apis.p.rapidapi.com/json',
  headers: {
    'content-type': 'application/json',
    'X-RapidAPI-Key': '87dc11ece0msh0f19268a79aac3dp1a40fejsna8ec5ca21381',
    'X-RapidAPI-Host': 'ai-translation-apis.p.rapidapi.com'
  },
  data: `{"to":"ru","source":{"message":"${splitted[0]}"}}`
};

axios.request(options).then(function (response) {
	console.log(response.data);
    fs.appendFile('response.txt', response.data.data.translated.message, function (err) {
        if (err) return console.log(err);
        console.log('Success!');
      });
}).catch(function (error) {
	console.error(error);
});
