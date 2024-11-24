import React, { useState } from 'react';
import { Box, Button, FormControl, FilledInput, FormHelperText, TextField } from "@mui/material";
import Header from "../../../components/Header";
import SaveItemsAdmin from '../../saveItemAdmin';
import { useNavigate } from 'react-router-dom';


const AddWebsiteGallery = () => {
    const [title, setTitle] = useState('');
    const [image, setImage] = useState(null);
    const [description, setDescription] = useState('');
    const [date, setDate] = useState('');
    const navigate = useNavigate();

    const handleImageChange = (event) => {
        const selectedImage = event.target.files[0];
        setImage(selectedImage);
    };

    const handleAddGallery = async (event) => {
        event.preventDefault(); // Prevent the default form submission behavior
        const formData = new FormData();
        formData.append("image",image);

        try {
            const success = await SaveItemsAdmin.addGalleryAdmin(title, description, date,image);
            if (success) {
                navigate("/website-components-admin");
            } else {
                alert("Error Saving data");
            }
        } catch (error) {
            console.error("Saving Error:", error);
            alert("An error occurred while saving.");
        }
    };

    return (
        <Box>
            <Header title="Add Image" subtitle="Please Fill All the Fields" />
            <Box component="form" noValidate onSubmit={handleAddGallery} sx={{ display: 'flex', flexWrap: 'wrap', margin: 2 }}>
                <TextField
                    onChange={(e) => setTitle(e.target.value)}
                    label="Enter Image Title"
                    id="title"
                    sx={{ m: 1, width: '70%' }}
                    variant="filled"
                />
                <TextField
                    onChange={(e) => setDescription(e.target.value)}
                    label="Enter Description"
                    id="description"
                    sx={{ m: 1, width: '70%' }}
                    variant="filled"
                    multiline
                    rows={4}
                />
                <FormControl sx={{ m: 1, width: '70%' }} variant="filled">
                    <FilledInput
                        onChange={(e) => setDate(e.target.value)}
                        id='date'
                        type='date'
                    />
                    <FormHelperText id="filled-dob-helper-text">Publish Date</FormHelperText>
                </FormControl>
                <FormControl sx={{ m: 1, width: '70%' }} variant="filled">
                    <FilledInput
                        accept="image/*"
                        id="image-upload"
                        type="file"
                        onChange={handleImageChange}
                    />
                    <FormHelperText id="image-upload-helper-text">Upload Image</FormHelperText>
                </FormControl>
                <Button
                    type="submit"
                    sx={{ m: 1, width: '30.5%', marginTop: '20px' }}
                    color='success'
                    variant="contained"
                >
                    Save
                </Button>
            </Box>
        </Box>
    );
};

export default AddWebsiteGallery;