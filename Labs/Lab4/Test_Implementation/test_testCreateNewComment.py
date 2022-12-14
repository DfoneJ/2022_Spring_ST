# Generated by Selenium IDE
import pytest
import time
import json
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities

class TestTestCreateNewComment():
  def setup_method(self, method):
    self.driver = webdriver.Chrome()
    self.vars = {}
  
  def teardown_method(self, method):
    self.driver.quit()
  
  def test_testCreateNewComment(self):
    self.driver.get("http://127.0.0.1:3000/")
    self.driver.set_window_size(1833, 1030)
    self.driver.find_element(By.LINK_TEXT, "Open Admin UI").click()
    self.driver.find_element(By.CSS_SELECTOR, ".dashboard-group__list:nth-child(2) .dashboard-group__list-label").click()
    self.driver.find_element(By.CSS_SELECTOR, ".css-we21er > span").click()
    element = self.driver.find_element(By.CSS_SELECTOR, ".css-we21er > span")
    actions = ActionChains(self.driver)
    actions.move_to_element(element).perform()
    element = self.driver.find_element(By.CSS_SELECTOR, "body")
    actions = ActionChains(self.driver)
    actions.move_to_element(element, 0, 0).perform()
    self.driver.find_element(By.CSS_SELECTOR, "#react-select-2--value > .Select-placeholder").click()
    element = self.driver.find_element(By.CSS_SELECTOR, ".css-1ogg8o0")
    actions = ActionChains(self.driver)
    actions.move_to_element(element).release().perform()
    self.driver.switch_to.frame(0)
    self.driver.find_element(By.CSS_SELECTOR, "html").click()
    element = self.driver.find_element(By.ID, "tinymce")
    self.driver.execute_script("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>testCreateNewComment</p>'}", element)
  
