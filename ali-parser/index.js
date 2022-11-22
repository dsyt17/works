import cheerio from "cheerio";
import fs from "fs";
import mysql from "mysql2";

const file = process.argv[2];

const parse = () => {
  const data = fs.readFileSync(`${file ? `./${file}` : 'responce_html.txt'}`, "utf8");

  let $ = cheerio.load(data);
  $("#productDescriptBox br").remove();

  const item = {
    title: $(".pinfo-title").text(),
    raiting: $(".starts-num").text(),
    reviews: $(".rantings-num.gray").text(),
    wish_list: $("#wishCount").text(),
    description: $("#productDescriptBox").text(),
    full_price: $(".f16.gray").text(),
    current_price:
      $(".sale-price i.currency.mr5").text() +
      $(".sale-price i.low-sale-price").text(),
    // shop_raiting: $(".goodsStore_avgRate").text(),
    shippment:
      $(".tmiddle span.cost").text() +
      " to " +
      $(".tmiddle span.logistics-country").text() +
      " by " +
      $(".tmiddle span.logistics-type").text() +
      " on " +
      $(".logistics-time").text(),
    available: $(".stock-num.mr5").text(),
    image: $(".max-photo").find("img").attr("src"),
  };
  console.log(item);

  return item;
};

const writeToMySql = async (item) => {
  const connection = mysql.createConnection({
    host: "localhost",
    user: "admin",
    database: "wordpress",
    password: "225506",
    socketPath: "/var/run/mysqld/mysqld.sock",
  });

connection.connect((err) => {
  if (err) {
    return console.error("Ошибка: " + err.message);
  }
  else{
    console.log("Подключение к серверу MySQL успешно установлено");
  }
      var date = `${new Date().getDate()}.${new Date().getMonth()}.${+new Date().getFullYear()}`

      var sql = "INSERT INTO `wp_posts` (`ID`, `post_author`, `post_date`, `post_date_gmt`, `post_content`, `post_title`, `post_excerpt`, `post_status`, `comment_status`, `ping_status`, `post_password`, `post_name`, `to_ping`, `pinged`, `post_modified`, `post_modified_gmt`, `post_content_filtered`, `post_parent`, `guid`, `menu_order`, `post_type`, `post_mime_type`, `comment_count`) "
                +`VALUES (NULL, '1', '${date}', '${date}', '<!-- wp:paragraph -->\r\n<p><strong>Текущая цена:</strong> ${item.current_price}</p>\r\n<p><strong>Цена без скидки:</strong> ${item.full_price}</p>\r\n<p>Рейтинг: ${item.raiting} Из ${item.reviews} оценок</p>\r\n<p>Остаток: ${item.available} штук; В желаемом ${item.wish_list} оценок</p>\r\n<p>Доставка: ${item.shippment}</p>\r\n<img src="${item.image}"></img>\r\n<!-- /wp:paragraph -->', '${item.title}', '', 'publish', 'open', 'open', '', '${Math.floor(Math.random() * 100000000000000001)}', '', '', '2022-10-28 16:41:46', '2022-10-28 16:41:46', '', '0', 'http://goncharovigor.com/?p=1111', '0', 'post', '', '0'); `;
  
      connection.query(sql, function (err, result) {
          if (err) {
          return console.error("Ошибка: " + err.message);
      }
      console.log("Запись вставлена");

      connection.end((err) => {
        if (err) {
                return console.log("Ошибка: " + err.message);
            }
        console.log("Подключение закрыто");
        });

      });
      

});

};

const item = parse();
writeToMySql(item)
