import SwiftUI
import shared
    
struct HomeSearch: View {
    var carousselMovie: [Movie]
    
    @State private var currentIndex = 0
    @State private var labelHeight = CGFloat.zero
    
    var body: some View {
        TabView {
            ForEach(carousselMovie, id: \.self) { image in
                CarousselImage(
                    carousselImage: image.backdropPath,
                    movieTitle: image.title
                )
            }
        }
        .tabViewStyle(PageTabViewStyle())
        .frame(height: 250)
        .border(Color.green)
    }
}

struct CarousselImage: View {
    var carousselImage: String
    var movieTitle: String
    
    var body: some View {
        AsyncImage(url: URL(string: carousselImage)) { image in
            if image.image != nil {
                image.image!
                    .resizable()
                    .scaledToFill()
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
                    .clipped()
                    .border(Color.blue)
            } else if image.error != nil {
                Text("Image Load Error")
            } else {
                ProgressView()
            }
        }
        .border(Color.purple)
        .overlay(
            alignment: .topLeading,
            content: {
                HStack {
                    Spacer().frame(width: 20)
                    Text(movieTitle)
                        .bold()
                        .foregroundColor(Color.white)
                        .padding()
                }
            }
        )
    }
}
