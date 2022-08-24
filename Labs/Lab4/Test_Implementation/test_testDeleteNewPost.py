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

class TestTestDeleteNewPost():
  def setup_method(self, method):
    self.driver = webdriver.Chrome()
    self.vars = {}
  
  def teardown_method(self, method):
    self.driver.quit()
  
  def test_testDeleteNewPost(self):
    self.driver.get("http://127.0.0.1:3000/")
    self.driver.set_window_size(1833, 1030)
    self.driver.find_element(By.LINK_TEXT, "Open Admin UI").click()
    self.driver.find_element(By.CSS_SELECTOR, ".dashboard-group:nth-child(1) .dashboard-group__list:nth-child(1) .dashboard-group__list-tile").click()
    self.driver.find_element(By.CSS_SELECTOR, "tr:nth-child(3) .octicon").click()
    self.driver.find_element(By.CSS_SELECTOR, ".css-t4884").click()
    element = self.driver.find_element(By.CSS_SELECTOR, ".css-t4884")
    actions = ActionChains(self.driver)
    actions.move_to_element(element).perform()
  
