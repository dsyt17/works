from selenium import webdriver
import time
import sys

url = sys.argv[1]
driver = webdriver.Chrome(executable_path='./chromedriver')

try:
    driver.get(url=url)
    time.sleep(7)
    html = driver.page_source
    time.sleep(2)
    f = open("response_html.txt", "w")
    f.write(html)
    f.close()
except Exception as ex:
    print(ex)

finally:
    driver.close()
    driver.quit()