import axios from 'axios';

const API_BASE_URL = 'http://localhost:8082';

const AuthService = {
    async login(userEmail, userPassword) {
      try {
        if (!userEmail || !userPassword) {
          return false;
        }

        const formData = new FormData();
        formData.append('userEmail', userEmail);
        formData.append('userPassword', userPassword);

        const response = await axios.post(`${API_BASE_URL}/api/users`, 
          formData,
          {
            headers: {
              'Content-Type': 'multipart/form-data',
            },
          }
        );
  
        if (response.status === 200 && response.data.token) {
          localStorage.setItem('jwtToken', response.data.token);
          localStorage.setItem('userName', response.data.userName);
          return true;
        }
        return false;
      } catch (error) {
        console.error('Login failed:', error);
        return false;
      }
    },

    logout() {
      localStorage.removeItem('jwtToken');
      localStorage.removeItem('userName');
      localStorage.clear();
    },

    isAuthenticated() {
      return !!localStorage.getItem('jwtToken');
    }
};

export default AuthService;
