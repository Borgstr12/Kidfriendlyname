from requests_html import HTMLSession
class Job:
    def __init__(Jobtitle,salary,Primarylocation):
        Job.money = salary
        Job.title = Jobtitle
        Job.location = Primarylocation



session = HTMLSession()
r= session.get("https://ca.indeed.com/jobs?q=transportation+engineering&l=toronto%2C+on&radius=25&from=searchOnDesktopSerp&start=0&vjk=89d04b7fa5684923")
