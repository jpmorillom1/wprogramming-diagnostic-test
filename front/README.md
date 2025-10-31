# Diagnostic Test Frontend

A Pokémon battle simulator desktop application built with Electron. This interactive desktop app allows users to select two Pokémon and view their information side-by-side, making it perfect for comparing Pokémon before battles.

## Features

- 🎮 **Dual Pokémon Selection**: Choose two different Pokémon for comparison
- 🔍 **Pokémon Search**: Look up any Pokémon by ID (1-898+)
- 📊 **Pokémon Information Display**: View name, types, and sprite images
- 💻 **Desktop Application**: Native desktop experience powered by Electron
- 🎨 **Modern UI**: Beautiful card-based interface with Bootstrap and custom CSS
- 📱 **Responsive Design**: Mobile-friendly layout with media queries
- ⚡ **Real-time Updates**: Dynamic content loading from REST API

## Tech Stack

- **Electron 38.4.0**: Desktop application framework
- **HTML5**: Markup structure
- **CSS3**: Custom styling with animations and hover effects
- **Bootstrap 5.3.2**: Responsive UI components
- **Vanilla JavaScript**: No frameworks, pure JS for API calls and DOM manipulation

## Prerequisites

- **Node.js**: v14.0.0 or higher
- **npm**: v6.0.0 or higher
- **Backend API**: The backend service must be running on `http://localhost:8080`

## Installation

1. Navigate to the frontend directory:
```bash
cd front
```

2. Install dependencies:
```bash
npm install
```

This will install Electron and all required dependencies defined in `package.json`.

## Running the Application

### Development Mode

Start the Electron desktop application:
```bash
npm start
```

The application will launch in a desktop window (800x600).

## Project Structure

```
front/
├── index.html           # Main HTML structure
├── main.js             # Electron main process configuration
├── styles.css          # Custom CSS styling
├── package.json        # Node.js dependencies and scripts
├── package-lock.json   # Dependency lock file
└── node_modules/       # Installed npm packages (generated)
```

## How It Works

### Architecture

The application consists of:

1. **Main Process** (`main.js`): 
   - Creates the Electron BrowserWindow
   - Loads the HTML file
   - Handles window lifecycle events

2. **Renderer Process** (`index.html`):
   - Contains the UI with two Pokémon cards
   - Includes inline JavaScript for API calls
   - Manages user interactions

### Features Breakdown

#### Dual Pokémon Selection
- Two identical card interfaces for selecting Pokémon
- Each card has its own search input and button
- Independent API calls for each Pokémon

#### API Integration
The app makes REST API calls to the backend:
```javascript
fetch(`http://localhost:8080/api/pokemon/${id}`)
```

**API Endpoint:**
- `GET /api/pokemon/{id}`: Retrieves Pokémon data

**Response Handling:**
- Displays Pokémon sprite image
- Shows Pokémon name in uppercase
- Lists Pokémon types
- Handles errors gracefully

#### UI Components

**Cards:**
- Centered, responsive layout using Flexbox
- Smooth hover effects with scaling and shadow changes
- Rounded corners and modern shadows

**Search Input:**
- Number input for Pokémon ID
- Styled submit button with hover effects
- Validates input before making API calls

**Responsive Design:**
- Desktop: Two cards side-by-side
- Mobile (< 768px): Cards stack vertically
- Touch-friendly button sizes

## Configuration

### API Base URL

The backend API URL is hardcoded in `index.html`:
```javascript
fetch(`http://localhost:8080/api/pokemon/${id}`)
```

To change the backend URL, modify the fetch call in the inline script section.

### Window Dimensions

Edit `main.js` to change the default window size:
```javascript
const win = new BrowserWindow({
  width: 800,  // Change width
  height: 600  // Change height
})
```

## Dependencies

```json
{
  "devDependencies": {
    "electron": "^38.4.0"
  }
}
```

### External CDN Resources

- **Bootstrap 5.3.2**: `https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/`

## Development

### Building for Distribution

To create a distributable application:

1. Install Electron Builder (if not already installed):
```bash
npm install --save-dev electron-builder
```

2. Add build configuration to `package.json`:
```json
{
  "build": {
    "appId": "com.uce.diagnostic-test",
    "productName": "Pokémon Battle Simulator",
    "directories": {
      "output": "dist"
    },
    "files": [
      "index.html",
      "main.js",
      "styles.css"
    ]
  }
}
```

3. Build the application:
```bash
npm run build
```

### Adding Features

Future enhancements could include:
- AI battle prediction display
- Battle history table implementation
- Save favorite Pokémon
- Export battle results

## Troubleshooting

### Application Won't Start

**Error**: Cannot find module 'electron'
```bash
# Solution: Reinstall dependencies
rm -rf node_modules package-lock.json
npm install
```

### API Connection Errors

**Error**: Failed to fetch Pokémon data

1. Verify backend is running: `http://localhost:8080/api/pokemon/1`
2. Check CORS configuration in backend
3. Ensure no firewall is blocking localhost connections

### Styling Issues

- Clear browser cache (Ctrl+F5 / Cmd+Shift+R)
- Check Bootstrap CDN connection
- Verify `styles.css` is loaded correctly

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## Backend Integration

This frontend requires the backend API to be running:

- Backend README: See `../back/diagnostic-test-backend/README.md`
- Default backend URL: `http://localhost:8080`
- CORS must be enabled in backend for cross-origin requests

## Browser Compatibility

While this is an Electron app, the underlying web technologies are:
- **Modern browsers**: Chrome, Edge, Firefox, Safari
- **HTML5**: Semantic elements and Fetch API
- **CSS3**: Flexbox, transitions, and modern features
- **ES6+ JavaScript**: Arrow functions, template literals

## License

This project is part of a diagnostic test for Web Programming coursework.

## Author

Developed for UCE (Universidad Central del Ecuador)

---

**Note**: This is an Electron desktop application. It requires Node.js and npm to run. The application serves as the frontend/client for the Pokémon diagnostic test system.

