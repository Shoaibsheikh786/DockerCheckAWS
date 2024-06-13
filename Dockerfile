# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Install dependencies for Chrome
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    xvfb \
    libxi6 \
    libgconf-2-4 \
    && rm -rf /var/lib/apt/lists/*

# Install Chrome
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# Install ChromeDriver
RUN CHROMEDRIVER_VERSION=`curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE` \
    && wget -N https://chromedriver.storage.googleapis.com/$CHROMEDRIVER_VERSION/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip \
    && chmod +x chromedriver \
    && mv -f chromedriver /usr/local/bin/chromedriver \
    && rm chromedriver_linux64.zip

# Set display port to avoid crash
ENV DISPLAY=:99

# Add your project files to the Docker image
COPY . /usr/src/app

# Set the working directory to the project directory
WORKDIR /usr/src/app

# Install any additional dependencies your project needs, for example Maven
# RUN apt-get update && apt-get install -y maven

# Run the command to execute your tests
RUN mvn clean package

