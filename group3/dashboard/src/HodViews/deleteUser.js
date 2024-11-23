import axios from 'axios';

const API_BASE_URL = 'http://localhost:8082';

const DeleteUser = {
    async deleteUserAdmin(id) {
        try {
            const token = localStorage.getItem('jwtToken');
            
            const response = await axios({
                method: 'delete',
                url: `${API_BASE_URL}/api/users/${id}`,
                headers: {
                    Authorization: `Bearer ${token}`,
                    'Content-Type': 'application/json'
                }
            });

            if (response.status === 204 || response.status === 200) {
                console.log('User deleted successfully');
                return true;
            }
        } catch (error) {
            console.error('Delete user error:', error.response?.data || error.message);
            throw new Error('Failed to delete user. Please try again.');
        }
    }
};

export default DeleteUser;