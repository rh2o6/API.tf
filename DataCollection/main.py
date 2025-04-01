import requests
from bs4 import BeautifulSoup

# URL of the TF2 weapons wiki page
url = "https://wiki.teamfortress.com/wiki/Weapons"

# Headers to mimic a browser request
headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36"
}

# Request the webpage
response = requests.get(url, headers=headers)
response.raise_for_status()

# Parse with BeautifulSoup
soup = BeautifulSoup(response.text, "html.parser")

# Dictionary to store class weapon data
weapon_data = {}

# Locate class sections (h2 headers)
for header in soup.find_all("h2"):
    class_name = header.find("span", class_="mw-headline")
    
    if class_name:
        class_name = class_name.text.strip()
        weapon_data[class_name] = {}

        # Find the next elements
        next_element = header.find_next_sibling()
        current_category = None

        while next_element and next_element.name != "h2":
            # If it's an h3, it's a category (Primary, Secondary, etc.)
            if next_element.name == "h3":
                category_name = next_element.find("span", class_="mw-headline")
                if category_name:
                    current_category = category_name.text.strip()
                    weapon_data[class_name][current_category] = []

            # If it's a table, extract weapon names (from <th>)
            elif next_element.name == "table" and "wikitable" in next_element.get("class", []):
                rows = next_element.find_all("tr")[1:]  # Skip table headers
                for row in rows:
                    weapon_cell = row.find("th")  # Find weapon name inside <th>
                    if weapon_cell and current_category:
                        weapon_name = weapon_cell.get_text(strip=True)

                        # Remove "Craft" and "Stock" from the name
                        weapon_name = weapon_name.replace("Craft", "").replace("Stock", "").strip()

                        if weapon_name:  # Ensure it's not empty
                            weapon_data[class_name][current_category].append(weapon_name)

            next_element = next_element.find_next_sibling()

# Print extracted data
for class_name, categories in weapon_data.items():
    print(f"\n{class_name}:")
    for category, weapons in categories.items():
        print(f"  {category}: {', '.join(weapons) if weapons else 'None'}")
