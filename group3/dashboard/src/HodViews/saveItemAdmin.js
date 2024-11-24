import axios from 'axios';

axios.defaults.withCredentials = true;

const API_BASE_URL = 'http://localhost:8082';


const SaveItemsAdmin = {
  async addTeamSave(email, password, firstName, lastName, phone, userName, image) {
    const token = await localStorage.getItem('jwtToken');
    
    // Create image URL if image is provided
    const imageUrl = image ? URL.createObjectURL(image) : null;

    try {
      const formData = new FormData();
      formData.append('userName', userName);
      formData.append('userEmail', email);
      formData.append('userPassword', password);
      formData.append('firstName', firstName);
      formData.append('lastName', lastName);
      formData.append('phoneNumber', phone);
      //formData.append('userImage', image);
      formData.append('userImage', imageUrl);

      const response = await axios.post(
        `${API_BASE_URL}/api/users`,
        formData,
        {
          headers: {
            'Content-Type': 'application/json',
            Authorization: `Bearer ${token}`,
          }
        }
      );

      if (response.status >= 200 && response.status < 300) {
        return response.data;
      }
      throw new Error('Failed to save team member');
    } catch (error) {
      console.error('Error details:', error.response?.data || error.message);
      throw new Error(error.response?.data?.message || 'Failed to save team member');
    }
  },

  async addProductAdmin( postShortDescription, tag, title, postSlug, content, status, date, image, place) {
    const token = await localStorage.getItem('jwtToken');
    const username = await localStorage.getItem('userName');

    try {
      const formData = new FormData();
      formData.append('author', username);
      formData.append('postShortDescription', postShortDescription);
      formData.append('tag', tag);
      formData.append('place', place);
      formData.append('title', title);
      formData.append('postSlug', postSlug);
      formData.append('content', content);
      formData.append('status', status);
      formData.append('date', date);

      if (image) {
        formData.append('image', image); // Assuming 'image' is the key on the server to handle file uploads
      }

      const response = await axios.post(
        `${API_BASE_URL}/api/products/addproduct`,
        formData,
        {
          headers: {
            'Content-Type': 'multipart/form-data', // Set content type to multipart/form-data for file uploads
            Authorization: `Bearer ${token}`,
          },
        }
      );

      if (response.status === 200) {
        return response.data;
      }
    } catch (error) {
      if (error.response) {
        console.error('Server responded with an error:', error.response.data);
      } else if (error.request) {
        console.error('No response received:', error.request);
      } else {
        console.error('Error setting up the request:', error.message);
      }
      throw error;
    }
  },
  async addGalleryAdmin(title, description, date, image) {
    const token = await localStorage.getItem('jwtToken');
    const imageUrl = image ? URL.createObjectURL(image) : null;
  
    try {
      // Create FormData object to handle the data (including image)
      const formData = new FormData();
      formData.append('title', title);
      formData.append('description', description);
      formData.append('date', date);
  
      // Append image if it's provided
      if (image) {
        formData.append('image', imageUrl); // 'image' should match the server key
      }

      const response = await axios.post(
        `${API_BASE_URL}/api/gallery`,
        formData,
        {
          headers: {
            'Content-Type': 'application/json', // Set content type to multipart/form-data for file uploads
            Authorization: `Bearer ${token}`,
          },
        }
      );

      if (response.status === 200) {
        return response.data;
      }
    } catch (error) {
      if (error.response) {
        console.error('Server responded with an error:', error.response.data);
      } else if (error.request) {
        console.error('No response received:', error.request);
      } else {
        console.error('Error setting up the request:', error.message);
      }
      throw error;
    }
  },
  async addWebsiteImageAdmin(place, tag, title, status, date, image) {

    const imageUrl = image ? URL.createObjectURL(image) : null;
    const formData = new FormData();
    
    formData.append('imageTitle', title);
 
    formData.append('tag', tag);
    formData.append('place', place);
    formData.append('status', status);
    formData.append('date', date);

    try {
        const response = await axios.post(
            `${API_BASE_URL}/api/websiteimages`,

            formData,
            {
                headers: {
                    'Content-Type': 'application/json',
                    Authorization: 'Bearer ${token}',
                },
            }
        );

        return response.data;

    }catch (error) {

        console.error('Error uploading image:', error);
        throw error;
    }
  },
  async addWebsiteTextAdmin(title, description, status) {
    const token = await localStorage.getItem('jwtToken');
    const username = await localStorage.getItem('userName');

    try {

      const formData = new FormData();
      formData.append('author', username);
      formData.append('description', description);
      formData.append('title', title);
     
      formData.append('status', status);
    
   
      const response = await axios.post(
        `${API_BASE_URL}/api/websitetext`,
        formData,
        {
          headers: {
            'Content-Type': 'application/json', // Set content type to multipart/form-data for file uploads
            Authorization: `Bearer ${token}`,
          },  
        }
      );

      if (response.status === 200) {
        return response.data;
      }

    } catch (error) {
      console.error('Error in addWebsiteTextAdmin:', error);
      throw error;
    }
  },

  
};

export default SaveItemsAdmin;
