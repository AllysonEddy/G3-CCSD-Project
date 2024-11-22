import React, { useState } from 'react';
import { Box, Button, FormControl, InputLabel, Select, MenuItem, TextField } from "@mui/material";
import { useNavigate } from 'react-router-dom';
import SaveItemsAdmin from '../../saveItemAdmin';
import Header from "../../../components/Header";

const AddWebsiteText = () => {
    const [title, setTitle] = useState("");
    const [status, setStatus] = useState("");
    const [description, setDescription] = useState("");
    const navigate = useNavigate();

    const handleAddBlog = async (event) => {
        event.preventDefault(); // Prevent the default form submission behavior
      
        try {
          const success = await SaveItemsAdmin.addWebsiteTextAdmin(title, description, status);
          if (success) {
            navigate("/website-components-admin");
          } else {
            alert("Error saving data");
          }
        } catch (error) {
          console.error("Saving Error:", error);
          alert("An error occurred while saving.");
        }
    };

    return (
        <Box>
            <Header title="Add Website Text" subtitle="Please Fill All the Fields" />
            <Box sx={{ display: 'flex', flexWrap: 'wrap' }} component="form" noValidate onSubmit={handleAddBlog}>
                {/* Title Input */}
                <TextField
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    label="Enter Text Title"
                    id="title"
                    sx={{ m: 1, width: '45%' }}
                    variant="filled"
                    required
                />

                {/* Status Select */}
                <FormControl sx={{ m: 1, width: '45%' }} variant="filled" required>
                    <InputLabel id="status">Status</InputLabel>
                    <Select
                        labelId="status"
                        id="status"
                        value={status}
                        onChange={(e) => setStatus(e.target.value)}
                    >
                        <MenuItem value={0}>Draft</MenuItem>
                        <MenuItem value={1}>Publish</MenuItem>
                    </Select>
                </FormControl>

                {/* Description Input */}
                <TextField
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    label="Enter Description"
                    id="description"
                    sx={{ m: 1, width: '93%' }}
                    variant="filled"
                    multiline
                    rows={4}
                    required
                />

                {/* Save Button */}
                <Button
                    type="submit"
                    sx={{ m: 1, width: '93%' }}
                    color="success"
                    variant="contained"
                >
                    Save
                </Button>
            </Box>
        </Box>
    );
};

export default AddWebsiteText;
