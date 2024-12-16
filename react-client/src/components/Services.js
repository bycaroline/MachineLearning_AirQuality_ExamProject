import axios from "axios";


const API_LILLAESSINGEN_URL = 'http://localhost:8088/predictlillaessingen';
const API_HORNSG_URL = 'http://localhost:8088/predicthornsg';
const API_STERIKS_URL = 'http://localhost:8088/predictsteriks';
const API_SVEAV_URL = 'http://localhost:8088/predictsveav';
const API_TORKEL_URL = 'http://localhost:8088/predicttorkel';



export const predictLillaEssingen = async (time) => {
    try {
        const response = await axios.post(`${API_LILLAESSINGEN_URL}`, {
            features: [time],
        });
        return response.data;
    } catch (error) {
        console.error('Kunde inte hämta uppskattning', error);
        throw error;
    }
};


export const predictHornsgatan = async (time) => {
    try {
        const response = await axios.post(`${API_HORNSG_URL}`, {
            features: [time],
        });
        return response.data;
    } catch (error) {
        console.error('Kunde inte hämta uppskattning', error);
        throw error;
    }
};


export const predictStEriksgatan = async (time) => {
    try {
        const response = await axios.post(`${API_STERIKS_URL}`, {
            features: [time],
        });
        return response.data;
    } catch (error) {
        console.error('Kunde inte hämta uppskattning', error);
        throw error;
    }
};

export const predictSveavägen = async (time) => {
    try {
        const response = await axios.post(`${API_SVEAV_URL}`, {
            features: [time],
        });
        return response.data;
    } catch (error) {
        console.error('Kunde inte hämta uppskattning', error);
        throw error;
    }
};

export const predictTorkelKnutssongatan = async (time) => {
    try {
        const response = await axios.post(`${API_TORKEL_URL}`, {
            features: [time],
        });
        return response.data;
    } catch (error) {
        console.error('Kunde inte hämta uppskattning', error);
        throw error;
    }
};






