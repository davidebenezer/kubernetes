# Copilot Instructions for Math Quiz Application

<!-- Use this file to provide workspace-specific custom instructions to Copilot. For more details, visit https://code.visualstudio.com/docs/copilot/copilot-customization#_use-a-githubcopilotinstructionsmd-file -->

## Project Overview
This is a full-stack Math Quiz web application built with Spring Boot backend and modern frontend designed specifically for kids.

## Architecture Guidelines
- **Backend**: Spring Boot with REST APIs, Spring Security for authentication, JPA for data persistence
- **Frontend**: Modern HTML/CSS/JavaScript with colorful, kid-friendly UI design
- **Database**: H2 in-memory database for development, easily configurable for production
- **Security**: Role-based authentication (ADMIN/USER roles)

## Design Principles
- **Kid-Friendly**: Use bright colors, fun animations, and engaging UI elements
- **Responsive**: Mobile-first design that works on tablets and phones
- **Accessibility**: Clear fonts, good contrast, simple navigation
- **Gamification**: Progress bars, achievements, encouraging messages

## API Design
- RESTful endpoints following standard conventions
- Proper HTTP status codes and error handling
- JSON responses with consistent structure
- Input validation and sanitization

## Frontend Guidelines
- Use CSS Grid/Flexbox for layouts
- Implement smooth animations and transitions
- Use modern JavaScript (ES6+) features
- Progressive enhancement for better accessibility

## Security Considerations
- CSRF protection enabled
- Input validation on both frontend and backend
- Secure password handling
- Session management

## Testing
- Unit tests for service layer
- Integration tests for REST endpoints
- Frontend component testing where applicable

## Code Style
- Follow Spring Boot best practices
- Use meaningful variable and method names
- Add comprehensive JavaDoc comments
- Keep methods small and focused
