import SwiftUI
import shared

struct BackgroundPoster: View {
    var grade: String
    var title: String
    var backgroundPoster: String
    var poster: String
    var id: String
    var movie: Movie

    var body: some View {
        NavigationLink(destination: DetailScreen.init(movie: movie) {
            ZStack {
                AsyncImage(url: URL(string: backgroundPoster)) { image in
                    if image.image != nil {
                        image.image!
                            .resizable()
                            .scaledToFill()
                            .overlay(
                                alignment: .bottomTrailing,
                                content: {
                                    Grade(grade: grade)
                                        .padding(.trailing, 40)
                                }
                            )
                    } else if image.error != nil {
                        Text("Image Load Error")
                    } else {
                        //ProgressView()
                        Color.gray
                    }
                }
                PosterTitle(
                    title: title,
                    imageName: poster
                )
                .offset(x: 0, y: 75)
            }
            .clipped()
        }
        .background(Color.gray)
        .cornerRadius(4)
    }
}

struct Grade: View {
    var grade: String
    
    var body: some View {
        HStack {
            Text(grade)
                .bold()
                .padding(.leading, 8)
            Image(systemName: "star")
                .font(.title2)
                .foregroundColor(.white)
        }
        .background(Color.gray)
        .cornerRadius(4)
    }

//#Preview {
//    BackgroundPoster()
//}
