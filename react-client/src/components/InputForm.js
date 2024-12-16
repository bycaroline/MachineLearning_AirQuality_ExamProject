
import React, { useState } from 'react';
import { predictLillaEssingen } from './Services';
import { predictHornsgatan } from './Services';
import { predictStEriksgatan } from './Services';
import { predictSveavägen } from './Services';
import { predictTorkelKnutssongatan } from './Services';


function InputForm() {
    const [place, setPlace] = useState('');
    const [response, setResponse] = useState('');
    const [numericalValue, setNumericalValue] = useState('');

    const handlePlace = (event) => {
        setPlace(event.target.value);
    }

    const handleTime = (event) => {
        const timeInput = event.target.value;
        const [hours, minutes] = timeInput.split(".").map(Number);

        if (!isNaN(hours) && !isNaN(minutes)) {
            const totalSeconds = hours * 3600 + minutes * 60;
            setNumericalValue(totalSeconds);
        } else {
            setNumericalValue(0);
        }
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        const predictionFunctions = {
            LillaEssingen: predictLillaEssingen,
            Hornsgatan: predictHornsgatan,
            StEriksgatan: predictStEriksgatan,
            Sveavägen: predictSveavägen,
            TorkelKnutssongatan: predictTorkelKnutssongatan,
        };

        if (predictionFunctions[place]) {
            try {
                const data = await predictionFunctions[place](numericalValue);
                setResponse(data);
            } catch (e) {
                console.error("Gick inte att hitta plats", place, e);
            }
        } else {
            console.warn("Gick inte att hitta:", place);
        }
    };
    const responseDescriptions = [
        'Mycket låg partikelhalt',
        'Låg partikelhalt',
        'Ganska låg partikelhalt',
        'Måttlig partikelhalt',
        'Ganska hög partikelhalt',
        'Hög partikelhalt',
        'Mycket Hög partikelhalt',
        'Extremt hög partikelhalt',
        'Farligt hög partikelhalt',
    ];

    return (
        <section style={{ fontFamily: 'Arial, sans-serif', maxWidth: '400px', margin: '20px auto', padding: '50px', borderRadius: '8px', backgroundColor: '#FFFFFF', opacity: '0.8' }}>
            <div style={{ fontFamily: 'Arial, sans-serif' }}>
                <h1 style={{ textAlign: 'center' }}>Luftkvalitet i Stockholm</h1>
                <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '16px' }}>
                    <label style={{ fontSize: '14px', color: '#333' }}>
                        Välj en plats i Stockholm:
                        <select value={place} onChange={handlePlace} style={{ width: '100%', padding: '8px', marginTop: '8px', marginBottom: '15px', fontSize: '14px', border: '1px solid #ccc', borderRadius: '4px', backgroundColor: '#fff' }}>
                            <option value="">Välj en plats</option>
                            <option value="LillaEssingen">Lilla Essingen</option>
                            <option value="Hornsgatan">Hornsgatan</option>
                            <option value="StEriksgatan">St Eriksgatan</option>
                            <option value="Sveavägen">Sveavägen</option>
                            <option value="TorkelKnutssongatan">Torkel Knutssongatan</option>
                        </select>
                    </label>
                    <div>
                        <p style={{ fontSize: '16px', color: '#333', marginBottom: '8px' }}>Välj vilken tidpunkt</p>
                        <input
                            type="text"
                            onChange={handleTime}
                            style={{ width: '40%', padding: '8px', fontSize: '14px', border: '1px solid #ccc', borderRadius: '4px', backgroundColor: '#fff' }}
                            placeholder="Skriv in tid som HH.MM" />
                    </div>
                    <button type="submit" style={{ padding: '10px', fontSize: '14px', color: '#fff', backgroundColor: '#4B0082', border: 'none', borderRadius: '4px', cursor: 'pointer', transition: 'background-color 0.3s' }}>
                        Sök
                    </button>
                </form>
                <h3>Resultat:</h3>
                <p>{response !== undefined ? responseDescriptions[response] : ""}</p>
            </div>
        </section>
    )
}

export default InputForm