FROM selenium/standalone-chrome

# Set the working directory
WORKDIR /app

# Copy the project files to the container
COPY . .

# Install required dependencies
RUN apt-get update && apt-get install -y \
    openjdk-11-jdk \
    maven \
    && rm -rf /var/lib/apt/lists/*

# Command to execute the tests
CMD ["mvn", "test"]
