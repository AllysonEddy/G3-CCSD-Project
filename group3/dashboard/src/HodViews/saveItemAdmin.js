import axios from "axios";

axios.defaults.withCredentials = true;

const API_BASE_URL = "http://localhost:8082";

const SaveItemsAdmin = {
  async addTeamSave(
    email,
    password,
    firstName,
    lastName,
    phone,
    userName,
    image
  ) {
    const token = await localStorage.getItem("jwtToken");

    // Create image URL if image is provided
    //const imageUrl = image ? URL.createObjectURL(image) : null;

    try {
      const formData = new FormData();

      formData.append('userName', userName);
      formData.append('userEmail', email);
      formData.append('userPassword', password);
      formData.append('firstName', firstName);
      formData.append('lastName', lastName);
      formData.append('phoneNumber', phone);
      if (image) {
        formData.append('userImage', image);
      }
      //formData.append('userImage', imageUrl);

      const response = await axios.post(
        `${API_BASE_URL}/api/users`,
        formData,
        {
          headers: {
            "Content-Type": "multipart/form-data",
            Authorization: `Bearer ${token}`,
          }
        }
      );

      
      if (response.status === 200) {
        return response.data;
      }

      throw new Error("Failed to save team member");
    } catch (error) {
      console.error("Error details:", error.response?.data || error.message);
      throw new Error(
        error.response?.data?.message || "Failed to save team member"
      );

    }
  },

  async addProductAdmin(
    place,
    postShortDescription,
    tag,
    title,
    postSlug,
    content,
    status,
    date,
    image
  ) {
    const token = await localStorage.getItem("jwtToken");
    const username = await localStorage.getItem("userName");

    try {
      const formData = new FormData();
      // formData.append("author", username);
      formData.append("productDesc", postShortDescription);
      formData.append("productTags", tag);
      formData.append("productPlace", place);
      formData.append("productTitle", title);
      formData.append("productSlug", postSlug);
      formData.append("productLongDesc", content);
      formData.append("productStatus", status);
      // formData.append("productPublishDate", date);
      // Format the date to ISO-8601
      const formattedDate = new Date(date).toISOString();
      formData.append("productPublishDate", formattedDate);

      if (image) {
        formData.append("productImage", image); // Assuming 'image' is the key on the server to handle file uploads
      }

      console.log(formData);

      const response = await axios.post(
        `${API_BASE_URL}/api/products/addProduct`,
        formData,
        {
          headers: {
            "Content-Type": "application/json", // Set content type to multipart/form-data for file uploads
            Authorization: `Bearer ${token}`,
          },
        }
      );

      if (response.status === 200) {
        return response.data;
      }
    } catch (error) {
      if (error.response) {
        console.error("Server responded with an error:", error.response.data);
      } else if (error.request) {
        console.error("No response received:", error.request);
      } else {
        console.error("Error setting up the request:", error.message);
      }
      throw error;
    }
  },
  async addGalleryAdmin(title, description, date, image) {

    const token = localStorage.getItem('jwtToken');
    const formData = new FormData();

    formData.append('title', title);
    formData.append('description', description);
    formData.append('date', date);

    if (image) {
      formData.append('image', image); // Appends the image file
    }

 

    try {
      const response = await axios.post(
        `${API_BASE_URL}/api/gallery`,
        formData,
        {
          headers: {

            'Content-Type': 'multipart/form-data',
            "Content-Type": "application/json", // Set content type to multipart/form-data for file uploads

            Authorization: `Bearer ${token}`,
          },
        }
      );

      return response.data;
    } catch (error) {

      if (error.response) {
        console.error("Server responded with an error:", error.response.data);
      } else if (error.request) {
        console.error("No response received:", error.request);
      } else {
        console.error("Error setting up the request:", error.message);
      }

      throw error;
    }
  },
  async addWebsiteImageAdmin(place, tag, title, status, date, image) {
    const imageUrl = image ? URL.createObjectURL(image) : null;
    const formData = new FormData();

    
    formData.append('imageTitle', title);
    formData.append('image', image);
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
            "Content-Type": "application/json",
            Authorization: "Bearer ${token}",
          },
        }
      );

      return response.data;
    } catch (error) {
      console.error("Error uploading image:", error);
      throw error;
    }
  },
  async addWebsiteTextAdmin(title, description, status) {
    const token = await localStorage.getItem("jwtToken");
    const username = await localStorage.getItem("userName");

    try {
      const formData = new FormData();
      formData.append("author", username);
      formData.append("description", description);
      formData.append("title", title);

      formData.append("status", status);

      const response = await axios.post(
        `${API_BASE_URL}/api/websitetext`,
        formData,
        {
          headers: {
            "Content-Type": "application/json", // Set content type to multipart/form-data for file uploads
            Authorization: `Bearer ${token}`,
          },
        }
      );

      if (response.status === 200) {
        return response.data;
      }
    } catch (error) {
      console.error("Error in addWebsiteTextAdmin:", error);
      throw error;
    }
  },
};

export default SaveItemsAdmin;
