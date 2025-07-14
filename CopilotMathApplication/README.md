# 🎯 Math Quiz Web Application

A beautiful, kid-friendly web application for learning mathematics through interactive quizzes. Built with Spring Boot and designed specifically to make math learning fun and engaging for children.

## ✨ Features

### 👦👧 For Students
- **Interactive Math Quizzes**: Practice addition, subtraction, multiplication, and division
- **Kid-Friendly Design**: Colorful, engaging UI with smooth animations
- **Progress Tracking**: Monitor learning progress and accuracy
- **Timer-Based Questions**: Customizable timeout settings
- **Break System**: Take breaks during long quiz sessions
- **Responsive Design**: Works perfectly on tablets and phones

### 👩‍🏫 For Administrators  
- **Admin Dashboard**: Complete control over quiz settings
- **Customizable Settings**: Adjust timeouts, question counts, difficulty levels
- **User Management**: View and manage registered students
- **Operation Controls**: Enable/disable specific math operations
- **Number Range Settings**: Set minimum and maximum numbers for questions

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Installation

1. **Clone or Download** the project to your computer

2. **Navigate to the project directory**:
   ```bash
   cd math-quiz-app
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

4. **Open your web browser** and go to:
   ```
   http://localhost:8080
   ```

### Default Admin Login
- **Username**: `admin`
- **Password**: `admin`

## 🎮 How to Use

### For Students
1. **Register**: Create a new account with your name, age, and grade
2. **Login**: Use your credentials to access the dashboard
3. **Start Quiz**: Choose an operation type (addition, subtraction, etc.)
4. **Practice**: Answer questions within the time limit
5. **View Results**: See your score and accuracy after completing the quiz

### For Administrators
1. **Login** with admin credentials (`admin`/`admin`)
2. **Access Admin Panel**: Click on "Admin Dashboard" from your dashboard
3. **Customize Settings**: 
   - Adjust question timeout (5-120 seconds)
   - Set questions per session (5-200 questions)
   - Configure break settings
   - Enable/disable math operations
   - Set number ranges for questions
4. **Manage Users**: View all registered students and their information

## 🛠 Technical Details

### Built With
- **Backend**: Spring Boot 3.5, Spring Security, Spring Data JPA
- **Frontend**: HTML5, CSS3, JavaScript, Thymeleaf
- **Database**: H2 (in-memory for development)
- **Styling**: Custom CSS with kid-friendly animations

### Architecture
- **MVC Pattern**: Clean separation of concerns
- **RESTful APIs**: For quiz operations and data management
- **Responsive Design**: Mobile-first approach
- **Security**: Role-based authentication (USER/ADMIN)

### Database Schema
- **Users**: Student and admin accounts with profiles
- **Quiz Sessions**: Completed quiz records
- **Question Results**: Individual question answers
- **Quiz Settings**: Customizable application settings

## 🎨 Design Philosophy

The application is designed with children in mind:
- **Bright, cheerful colors** to create a positive learning environment
- **Large, clear fonts** for easy reading
- **Intuitive navigation** that kids can understand
- **Encouraging messages** to boost confidence
- **Visual feedback** for correct and incorrect answers
- **Fun animations** to maintain engagement

## 📚 Educational Benefits

- **Math Skill Development**: Practice fundamental arithmetic operations
- **Time Management**: Learn to work within time constraints
- **Self-Paced Learning**: Students can practice at their own speed
- **Progress Tracking**: Monitor improvement over time
- **Gamification**: Quiz format makes learning feel like a game

## 🔧 Configuration

### Application Settings
Configure the application through `src/main/resources/application.properties`:

```properties
# Server port (default: 8080)
server.port=8080

# Database settings
spring.datasource.url=jdbc:h2:mem:mathquiz

# Quiz settings
app.quiz.default-timeout=20
app.quiz.max-questions=200
```

### Admin Customization
Administrators can customize through the web interface:
- Question timeouts (5-120 seconds)
- Questions per session (5-200)
- Break duration and frequency
- Enabled math operations
- Number difficulty ranges

## 🌟 Future Enhancements

- **More Math Operations**: Fractions, decimals, algebra
- **Achievement System**: Badges and rewards for milestones
- **Multiplayer Mode**: Compete with friends
- **Teacher Dashboard**: Classroom management features
- **Learning Analytics**: Detailed progress reports
- **Offline Mode**: Practice without internet connection

## 🤝 Contributing

We welcome contributions to make this educational tool even better! Whether you're adding new features, fixing bugs, or improving the documentation, your help is appreciated.

## 📞 Support

If you encounter any issues or have questions:
1. Check the browser console for any error messages
2. Ensure Java 17+ and Maven are properly installed
3. Verify the application is running on `http://localhost:8080`

## 📝 License

This project is created for educational purposes. Feel free to use, modify, and distribute for educational use.

---

**Made with ❤️ for young learners everywhere!**

*Let's make math fun and accessible for every child!* 🌟
