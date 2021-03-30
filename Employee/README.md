# Dynamic Load balancing with Nginx ,Consul and Consul-Template

**Step 1:**

Create tmp folder in your linux machine

**Step 2:**
Then go to tmp folder 

	cd tmp

Install below softwares
	
**i) Install Consul:**
	
    wget https://releases.hashicorp.com/consul/0.8.5/consul_0.8.5_linux_amd64.zip
    unzip consul_0.8.5_linux_amd64.zip
    
**ii) Install consul-template:**
	
	wget https://releases.hashicorp.com/consul-template/0.12.0/consul-template_0.12.0_linux_amd64.zip
	unzip consul-template_0.12.0_linux_amd64.zip

**iii) Install Nginx:**
   
      sudo apt-get install nginx
			
iv) Copy all files

	 from folder /Employee/src/main/resources/Scripts to tmp folder

**Step 3:**
Once you are done with installation start all services

**i) Start Nginx:**
	
	sudo services nginx start 
	
	To check nginx welcome page use below URL by default it run on 80 port
	http://localhost
	
**ii) Start consul:**
	
	Go to tmp folder that we already created and run consul_run.sh file before running edit file with your machine Ip address
	
	sh consul_run.sh
	
	To check consul UI go to below URL
	http://localhost:8500/ui/
	
**iii) Start consul-template:**
	Go to tmp folder that we already created and run consul_template.sh file
	
	sh consul_template.sh

**Step 4:**

Import this project in Spring Tool Suite(STS)
Run as spring boot application that will run on port no 9072

	To Access this application use Below URL
	http://localhost:9072/employee/get-employee-details/Bob
		
**Step 5:**

We will create one more instance of same application by changing portNumbe to 9073 in application.propertie file.

	server.port=9073
	
Again run this application as Spring boot application.
 	
	To Access this application use Below URL
	http://localhost:9073/employee/get-employee-details/Bob

**Step 6:**

Once you start application consul-template will generate nginx.conf file dynamically
to check updated nginx.config file run showNginxConfig.sh file using below command

	sh showNginxConfig.sh
	
**Step 7:**
We are done with all setup go to Postman or Browser and hit below URL

	http://localhost:9072/employee/get-employee-details/Bob
	
Once you hit that URL first time request will be serve by application running on port no 9072
hit that URL again next request will be serve by application instance running on port no 9073

All request will be server by Nginx using Round Robin algorithm

=============================END==========================
